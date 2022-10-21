package com.openkey.server.listneners;

import org.hibernate.annotations.Parameter;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class InvocationListener implements IAnnotationTransformer {
    int invocationCount;
    public InvocationListener(int count){
        invocationCount = count;
    }
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setInvocationCount(invocationCount);
        System.out.println(invocationCount);
    }
}
