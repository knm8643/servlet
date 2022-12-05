package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
    }

//  리퀘스트 정보들 요약
    private void printStartLine(HttpServletRequest request) {
        System.out.println("-- REQUEST-LINE start --");

        System.out.println("request.getMethod() =" + request.getMethod());
        System.out.println("request.getProtocal()=" + request.getProtocol());
        System.out.println("request.getScheme()=" + request.getScheme());

        System.out.println("request.getRequestURL()=" + request.getRequestURL());
        System.out.println("request.getRequestURI()=" + request.getRequestURI());

        System.out.println("request.getQueryString()=" + request.getQueryString());
        System.out.println("request.isSecure()=" + request.isSecure());
        System.out.println("-- REQUEST-LINE -- end --");
        System.out.println();
    }

//    모든해더 정보들 요약
    private void printHeaders(HttpServletRequest request) {
        System.out.println("--Headers Start--");

        //옛날방식
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()){
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + ": " + headerName);
//        }

        //요즘방식
        request.getHeaderNames().asIterator()
                        .forEachRemaining(headerName -> System.out.println("headerName = " + headerName));

        System.out.println("--Headers End--");
    }

    private void printHeaderUtils(HttpServletRequest request){
        System.out.println("--Header 편의 조회 start --");
        System.out.println("Host편의 조희");
        System.out.println("request.getServerName() =" +request.getServerName()); // host 해더
        System.out.println("request.getServerPort() =" +request.getServerPort());

        System.out.println("Accept-Language 편의 조회");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale =" + locale));
        System.out.println("request.getLocale() = " + request.getLocale());

        System.out.println("cookie 편의 조회");
//        if(request.getCookies() != null){
//            for(Cookie cookie : request.getCookies()){
//                System.out.println(cookie.getName() + ":" + cookie.getValue());
//            }
//        }

        System.out.println("Content 편의 조회");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() =" + request.getContentLength());
        System.out.println("request.getCharacterEncoding = " + request.getCharacterEncoding());
        System.out.println("-- Header 편의 조회 end ---");
    }
}
