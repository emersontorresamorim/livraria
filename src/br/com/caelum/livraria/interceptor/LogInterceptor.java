package br.com.caelum.livraria.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptor {

	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		long inicio = System.currentTimeMillis();
		
		String metodo = context.getMethod().getName();
		String classe = context.getTarget().getClass().getSimpleName();
		Object obj = context.proceed();
		
		System.out.println("Classe: " + classe + " - Método: " + metodo);
		System.out.println("Tempo gasto: " + (System.currentTimeMillis() - inicio));
		
		return obj;
	}
}
