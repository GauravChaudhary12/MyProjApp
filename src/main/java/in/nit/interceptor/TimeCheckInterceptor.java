package in.nit.interceptor;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeCheckInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		Calendar cl = Calendar.getInstance();
		int hour = cl.get(Calendar.HOUR_OF_DAY);
		System.out.println("TimeCheckInterceptor.preHandle()");
		if(hour<9 || hour>=19) {
			RequestDispatcher ds = req.getRequestDispatcher("/timeout.jsp");
			ds.forward(req, res);
			return false;
		}
		return true;
	}
}
