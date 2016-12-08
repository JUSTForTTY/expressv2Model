package com.hundsun.jresplus.quickstart.utils;

public class EncryptUtil {

	  public static String setEncrypt(String str){
	        String sn="wuyeok"; //密钥
	        int[] snNum=new int[str.length()];
	        String result="";
	        String temp="";

	        for(int i=0,j=0;i<str.length();i++,j++){
	            if(j==sn.length())
	                j=0;
	            snNum[i]=str.charAt(i)^sn.charAt(j);
	        }

	        for(int k=0;k<str.length();k++){

	            if(snNum[k]<10){
	                temp="00"+snNum[k];
	            }else{
	                if(snNum[k]<100){
	                    temp="0"+snNum[k];
	                }
	            }
	            result+=temp;
	        }
	        return result;
	    }

	    /**
	     * 密码解密,虽然用不到
	     * @return <code>String[]</code> 加密后字符串
	     * @author Administrator
	     * @since 1.0 2005/11/28
	     */
	    public static String getEncrypt(String str){
	        String sn="wuyeok"; //密钥
	        char[] snNum=new char[str.length()/3];
	        String result="";

	        for(int i=0,j=0;i<str.length()/3;i++,j++){
	            if(j==sn.length())
	                j=0;
	            int n=Integer.parseInt(str.substring(i*3,i*3+3));
	            snNum[i]=(char)((char)n^sn.charAt(j));
	        }

	        for(int k=0;k<str.length()/3;k++){
	            result+=snNum[k];
	        }
	        return result;
	    }

	}


