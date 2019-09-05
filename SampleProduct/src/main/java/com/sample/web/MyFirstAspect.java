package com.sample.web;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.sample.web.domain.Product;

@Aspect
@Component
public class MyFirstAspect {

	@Before("execution(* findByProductName(String))")
	public void before(JoinPoint jp) {
		//メソッド開始時に動作するAdvice
		System.out.println("Hello Before! *** メソッドが呼ばれる前に出てくるよ!");
		Signature sig = jp.getSignature();
		System.out.println("--->メソッド名を取得するよ：" + sig.getName());
		Object[] objs = jp.getArgs();
		System.out.println("---->引数の値を取得するよ：" + objs[0]);
	}

	@After("execution(* findByProductName(String))")
	public void after(JoinPoint jp) {
		//メソッド終了後に動作するAdvice
		System.out.println("Hello After! *** メソッドが呼ばれたあとに出てくるよ！");
		Signature sig = jp.getSignature();
		System.out.println("--->メソッド名を取得するよ：" + sig.getName());
		Object[] objs = jp.getArgs();
		System.out.println("---->引数の値を取得するよ：" + objs[0]);
	}

	@AfterReturning(value="execution(* findByProductName(String))", returning="product")
	public void afterReturning(Product product) {
		//メソッド呼び出しが例外の創出なしに終了した際に動作するAdvice
		System.out.println("Hello AfterReturning! *** メソッドを読んだ後に出てくるよ");
	}

	@Around("execution(* findByProductName(String))")
	public Product around(ProceedingJoinPoint pjp) throws Throwable {
		//メソッド呼び出しの前後に動作するAdvice
		System.out.println("Hello Around! before *** メソッドを呼ぶ前に出てくるよ！");

		//メソッド名の出力
		Signature sig = pjp.getSignature();
		System.out.println("----> aop:around メソッド名を取得するよ：" + sig.getName());

		Product p = (Product)pjp.proceed();
		System.out.println("Hello Arounf! after *** メソッドを読んだ後に出てくるよ");
		return p;
	}

	@AfterThrowing(value="execution(* findByProductName(String))", throwing="ex")
	public void afterThrowing(Throwable ex) {
		//メソッド呼び出しが例外を送出した際に動作するAdvice
		System.out.println("Hello Throwing! *** 例外になったらでてくるよ");
	}
}
