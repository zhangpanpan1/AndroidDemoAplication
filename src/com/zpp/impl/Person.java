package com.zpp.impl;

import java.util.HashMap;

import android.os.Parcel;
import android.os.Parcelable;
 /**
  	实现 Parcel的方法
  */
public class Person implements Parcelable {   

	public HashMap<String,String> map = new HashMap<String,String> ();
    public String name ;
    @Override  
    public int describeContents() {   
        return 0;   
    }   
    @Override  
    public void writeToParcel(Parcel dest, int flags) {   
  
        dest.writeMap(map);   
        dest.writeString(name);   
    }  
    
    //重写Creator
    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {   
    	@Override  
        public Person createFromParcel(Parcel source) {   
            Person p = new Person();   
            p.map=source.readHashMap(HashMap.class.getClassLoader());   
            p.name=source.readString();   
            return p;   
        }
        @Override  
        public Person[] newArray(int size) {   
            // TODO Auto-generated method stub   
            return null;   
        }   
    };   
  
}  