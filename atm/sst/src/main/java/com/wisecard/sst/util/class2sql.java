package com.wisecard.sst.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.springframework.validation.FieldError;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement.Else;

public class class2sql {

	public String select( Object o ){
		Class<?> cls = null; 
		StringBuffer stringBuffer = new StringBuffer();
		cls = o.getClass();
		do{
			Field[] fields = cls.getDeclaredFields();
			for( Field field : fields ){
				field.setAccessible( true );
				String name = field.getName();
				Object val = null;
				try {
					val = field.get( o );
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				}
				stringBuffer.append( name + "=" + obj2String(field.getClass(), val ) );
			}
		}while( ( cls = cls.getSuperclass() ) != Object.class );
		return "";
	}
	
	public void walk( Class<?> cls, Object object ){
		
	}
	
	
	public String obj2String( Class<?> cls, Object object ){
		if( int.class.isAssignableFrom( cls ) ){
			return Integer.toString( ( int )object ); 
		}else if( long.class.isAssignableFrom( cls ) ){
			return Long.toString( ( long )object );
		}else if( float.class.isAssignableFrom( cls ) ){
			return Float.toString( ( float )object );
		}else if( double.class.isAssignableFrom( cls ) ){
			return Double.toString( ( double )object );
		}else if( boolean.class.isAssignableFrom( cls ) ){
			return Boolean.toString( ( boolean )object );
		}else if( Enum.class.isAssignableFrom( cls ) ){
			return object.toString();
		}else if( byte.class.isAssignableFrom( cls ) ){
			return Byte.toString( ( byte )object );
		}else if( char.class.isAssignableFrom( cls ) ){
			return Character.toString( ( char )object );
		}else if( short.class.isAssignableFrom( cls ) ){
			return Short.toString( ( short )object );
		}else if( Array.class.isAssignableFrom( cls ) ){
			int index = 0;
			int iSize = Array.getLength( object );
			Object object2 = Array.get( object, index );
			String sub = obj2String(object2.getClass(), object2 );
			while( ++index < iSize ){
				
				
			}
		}else if( List.class.isAssignableFrom( cls ) ){
			
		}
		return "\"" + object.toString() + "\"";
	}
	
}
