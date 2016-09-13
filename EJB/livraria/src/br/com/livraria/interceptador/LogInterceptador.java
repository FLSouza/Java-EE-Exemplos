package br.com.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		long millis = System.currentTimeMillis();
		String metodo = context.getMethod().getName();
		String nomeClasse = context.getTarget().getClass().getSimpleName();

		Object o = context.proceed();

		System.out.println("[INFO] " + nomeClasse + "->" + metodo);
		System.out.println("Tempo gasto: " + (System.currentTimeMillis() - millis));
		
		return o;
	}
}
