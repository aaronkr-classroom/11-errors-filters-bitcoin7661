package ch12.com.filter;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;




public class InitParamFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) 
			throws ServletException {
		System.out.println("Filter02 초기화....");
		// this.filterConfig = filterConfig;
		
	}
	
	@Override 
	public void doFilter (
		ServletRequest req,
		ServletResponse res,
		FilterChain filterChain
		) throws IOException, ServletException {
			System.out.println("Filter02.jsp 수행...");
			String id = req.getParameter("id");
			String pw = req.getParameter("passwd");
			
			String param1 = filterConfig.getInitParameter("param1");
			String param2 = filterConfig.getInitParameter("param2");
			
			String message;
			
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = res.getWriter();
			
			
			
			if(id.equals(param1) && pw.equals(param2)) {
				message = "<h3> 로그인 성공했습니다!</h3>";
			} else {
				message ="<h3 style=\"color:red\"> 로그인 실패했습니다!</h3>";
			}
				
				
				String msg = "입력된 name 값은 null입니다.";
				writer.println(msg);
				return;
			}
			filterChain.doFilter(req, res);

	}
	@Override 
	public void destroy() {
		System.out.println("Filter01 해제....");
	}

}
