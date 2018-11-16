package com.niit.crudoperation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.H2Configuration;



/**
 * Hello world!
 *
 */
public class TableCreation 
{
    public static void main( String[] args )
    {
    	System.out.println( "WELCOME TO HIBERNATE APPLICATION" );
        ApplicationContext context=new AnnotationConfigApplicationContext(H2Configuration.class);
        System.out.println("TABLE CREATED SUCCESSFULLY");
    }
}
