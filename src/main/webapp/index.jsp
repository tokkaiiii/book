<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Title</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <jsp:include page="/WEB-INF/jsp/inc/header_link.jsp"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/index.css">
</head>
<body>
<main>
  <jsp:include page="/WEB-INF/jsp/common/header.jsp"/>
  <c:forEach begin="0" end="10" var="i">
    <section>
        <a href="/member/member.do?m=myPage">마이페이지</a>
      아 홍보글이에요
    </section>
  </c:forEach>

  <jsp:include page="/WEB-INF/jsp/common/footer.jsp"/>

</main>
</body>
</html>