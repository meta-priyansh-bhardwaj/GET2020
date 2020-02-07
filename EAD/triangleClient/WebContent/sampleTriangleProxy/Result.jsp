<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleTriangleProxyid" scope="session" class="triangle.TriangleProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleTriangleProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleTriangleProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleTriangleProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        triangle.Triangle getTriangle10mtemp = sampleTriangleProxyid.getTriangle();
if(getTriangle10mtemp == null){
%>
<%=getTriangle10mtemp %>
<%
}else{
        if(getTriangle10mtemp!= null){
        String tempreturnp11 = getTriangle10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String firstSide_1id=  request.getParameter("firstSide16");
        int firstSide_1idTemp  = Integer.parseInt(firstSide_1id);
        String secondSide_2id=  request.getParameter("secondSide18");
        int secondSide_2idTemp  = Integer.parseInt(secondSide_2id);
        String thirdSide_3id=  request.getParameter("thirdSide20");
        int thirdSide_3idTemp  = Integer.parseInt(thirdSide_3id);
        java.lang.String area13mtemp = sampleTriangleProxyid.area(firstSide_1idTemp,secondSide_2idTemp,thirdSide_3idTemp);
if(area13mtemp == null){
%>
<%=area13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(area13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>