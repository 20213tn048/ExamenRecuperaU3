package com.example.examenrecuperacionu3.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        name = "ServletMath",
        urlPatterns = {
               "/divisas",
                "/imc",
                "/descuento",
                "/temperatura"
        }
)
public class ServletMath extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getServletPath();
        switch(option){
            case "/temperatura":
                String celciusString =request.getParameter("celcius") != null ? request.getParameter ("celcius"):"0";
                try{
                    double celcius = Double.parseDouble(celciusString);
                    ServiceMath serviceMath = new ServiceMath();
                    double CtoF = serviceMath.calcularCtoF(celcius);
                    if (CtoF>=0){
                        request.setAttribute("celcius",celcius);
                        request.setAttribute("CtoF",CtoF);
                        request.getRequestDispatcher("/index.jsp").forward(request,response);
                    }else{
                        response.sendRedirect("/index.jsp");
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case "/imc":
                String alturaString = request.getParameter("altura") != null ? request.getParameter("altura"):"0";
                String pesoString = request.getParameter("peso") != null ? request.getParameter("peso"):"0";
                try{
                    double altura = Double.parseDouble(alturaString);
                    double peso = Double.parseDouble(pesoString);
                    ServiceMath serviceMath = new ServiceMath();
                    double imc = serviceMath.calcularIMC(altura,peso);
                    if(imc>=0){
                        request.setAttribute("altura",altura);
                        request.setAttribute("peso",peso);
                        request.setAttribute("imc",imc);
                        request.getRequestDispatcher("/index.jsp").forward(request,response);
                    }else{
                        response.sendRedirect("/index.jsp");
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                    response.sendRedirect("/index.jsp");
                }
                break;
            case "/descuento":
                String montoString = request.getParameter("monto") != null ? request.getParameter("monto"):"0";
                String porcentajeString = request.getParameter("porcentaje") != null ? request.getParameter( "porcentaje"):"0";
                try{
                    double monto  = Double.parseDouble(montoString);
                    double porcentaje = Double.parseDouble(porcentajeString);
                    ServiceMath serviceMath = new ServiceMath();
                    double descuento = serviceMath.calcularDescuento(monto,porcentaje);
                    if (descuento >= 0){
                        request.setAttribute("monto",monto);
                        request.setAttribute("porcentaje",porcentaje);
                        request.setAttribute("descuento",descuento);
                        request.getRequestDispatcher("/index.jsp").forward(request,response);
                    }else{
                        response.sendRedirect("/index.jsp");
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                    response.sendRedirect("/index.jsp");
                }
                break;
            case "/divisas":
                String dolaresString = request.getParameter("dolares") != null ? request.getParameter("dolares"):"0";
                String precioString = request.getParameter("precio") != null ? request.getParameter("precio"):"0";
                try{
                    double dolares = Double.parseDouble(dolaresString);
                    double precio = Double.parseDouble(precioString);
                    ServiceMath serviceMath = new ServiceMath();
                    double divisa = serviceMath.calcularDivisa(dolares,precio);
                    if (divisa>=0){
                        request.setAttribute("dolares",dolares);
                        request.setAttribute("precio",precio);
                        request.setAttribute("divisa",divisa);
                        request.getRequestDispatcher("/index.jsp").forward(request,response);
                    }else{
                        response.sendRedirect("/index.jsp");
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                    response.sendRedirect("/index.jsp");
                }
                break;
        }
    }
}
