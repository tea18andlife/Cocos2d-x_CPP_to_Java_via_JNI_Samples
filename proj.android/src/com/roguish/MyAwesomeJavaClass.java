/****************************************************************************
Copyright (c) 2008-2010 Ricardo Quesada
Copyright (c) 2010-2012 cocos2d-x.org
Copyright (c) 2011      Zynga Inc.
Copyright (c) 2013-2014 Chukong Technologies Inc.
 
http://www.cocos2d-x.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
****************************************************************************/
package com.roguish;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.cocos2dx.lib.Cocos2dxActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.text.format.DateFormat;

public class MyAwesomeJavaClass extends Cocos2dxActivity
{   
	static private int _times;
	static private String _helloTo;
	
    // sources for Java dialog: 
	// http://stackoverflow.com/questions/13377300/how-to-show-dialog-from-a-static-method
    // http://stackoverflow.com/questions/12051973/how-to-display-custom-dialog-in-cocos2dxactivity
	// http://stackoverflow.com/questions/4336470/how-do-i-close-an-android-alertdialog
	static void doMeAFavour()
    {
    	if ( Cocos2dxActivity.getContext() != null )  
    	{
    		( (Cocos2dxActivity) Cocos2dxActivity.getContext() ).runOnUiThread( new Runnable() 
    		{
    			public void run() 
    			{
    				AlertDialog.Builder builder = new AlertDialog.Builder( Cocos2dxActivity.getContext() );
	  		        builder.setTitle( "Java Method Called" );
	  		        builder.setMessage( "Method is: doMeAFavour" );
	  
	  		        builder.setPositiveButton( "OK", 
	  		        							new DialogInterface.OnClickListener() 
								  		        {  
								  		        	public void onClick( DialogInterface dialog, int id ) 
								  		        	{  
								  		        		dialog.dismiss(); 
								  		        	}  
								  		    	}); 
	  		        
	  		        AlertDialog alert = builder.create();
	  		        alert.show();  	  		        
    	        }
    	    });
    	}
    }
    
    static void doMeAFavourInt( int pTimes )
    {
    	_times = pTimes; 
    	if ( Cocos2dxActivity.getContext() != null )  
    	{
    		( (Cocos2dxActivity) Cocos2dxActivity.getContext() ).runOnUiThread( new Runnable() 
    		{
    			public void run() 
    			{
    				AlertDialog.Builder builder = new AlertDialog.Builder( Cocos2dxActivity.getContext() );
	  		        builder.setTitle( "Java Method Called" );
	  		        builder.setMessage( "Method is: doMeAFavourInt. Times: " + Integer.toString( _times ) );
	  
	  		        builder.setPositiveButton( "OK", 
	  		        							new DialogInterface.OnClickListener() 
								  		        {  
								  		        	public void onClick( DialogInterface dialog, int id ) 
								  		        	{  
								  		        		dialog.dismiss(); 
								  		        	}  
								  		    	}); 
	  		        
	  		        AlertDialog alert = builder.create();
	  		        alert.show();  	  		        
    	        }
    	    });
    	}
    }
    
    static String doMeAFavourString( int pStringTimes )
    {
    	_times = pStringTimes; 
    	if ( Cocos2dxActivity.getContext() != null )  
    	{
    		( (Cocos2dxActivity) Cocos2dxActivity.getContext() ).runOnUiThread( new Runnable() 
    		{
    			public void run() 
    			{
    				AlertDialog.Builder builder = new AlertDialog.Builder( Cocos2dxActivity.getContext() );
	  		        builder.setTitle( "Java Method Called" );
	  		        builder.setMessage( "Method is: doMeAFavourString. Times: " + Integer.toString( _times ) );
	  
	  		        builder.setPositiveButton( "OK", 
	  		        							new DialogInterface.OnClickListener() 
								  		        {  
								  		        	public void onClick( DialogInterface dialog, int id ) 
								  		        	{  
								  		        		dialog.dismiss(); 
								  		        	}  
								  		    	}); 
	  		        
	  		        AlertDialog alert = builder.create();
	  		        alert.show();  	  		        
    	        }
    	    });
    	}
    	
    	String tReturn = "doMeAFavourString return, pStringTimes:" + Integer.toString( pStringTimes );	
    	return tReturn;
    }
    
    static boolean sayHello( String to, int pSayHelloTimes )
    {
    	_times = pSayHelloTimes; 
    	_helloTo = to;
    	if ( Cocos2dxActivity.getContext() != null )  
    	{
    		( (Cocos2dxActivity) Cocos2dxActivity.getContext() ).runOnUiThread( new Runnable() 
    		{
    			public void run() 
    			{
    				AlertDialog.Builder builder = new AlertDialog.Builder( Cocos2dxActivity.getContext() );
	  		        builder.setTitle( "Java Method Called" );
	  		        builder.setMessage( "Method is: sayHello, To: " + _helloTo + ", Times: " + Integer.toString( _times ) );
	  
	  		        builder.setPositiveButton( "OK", 
	  		        							new DialogInterface.OnClickListener() 
								  		        {  
								  		        	public void onClick( DialogInterface dialog, int id ) 
								  		        	{  
								  		        		dialog.dismiss(); 
								  		        	}  
								  		    	}); 
	  		        
	  		        AlertDialog alert = builder.create();
	  		        alert.show();  	  		        
    	        }
    	    });
    	}
    	
    	return false;
    }

    // inspiration: http://discuss.cocos2d-x.org/t/jni-c-java-method-invocation-simple-example/4861
    static double[] getLocation()
    {	
    	LocationManager tLocationMgr = (LocationManager) ( (Cocos2dxActivity) Cocos2dxActivity.getContext() ).getSystemService( Context.LOCATION_SERVICE );
		String tBestProvider = tLocationMgr.getBestProvider( new Criteria(), true );
		Location tLocation = tLocationMgr.getLastKnownLocation( tBestProvider );
		double tLat = tLocation.getLatitude();
		double tLong = tLocation.getLongitude();		
		double[] locationData = { tLat, tLong };
		
		return locationData;
	}
    
    static void openBrowserURL( String pURL )
    {
        android.net.Uri tURI = android.net.Uri.parse( pURL );
        Intent tIntent = new Intent( Intent.ACTION_VIEW, tURI );
        ( (Cocos2dxActivity) Cocos2dxActivity.getContext() ).startActivity( tIntent );    	    
    }
}
