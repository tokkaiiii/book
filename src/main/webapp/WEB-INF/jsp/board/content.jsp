<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Title</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <jsp:include page="/WEB-INF/jsp/inc/header_link.jsp"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board/content.css">
  <script type="module" defer src="${pageContext.request.contextPath}/resources/js/board/content.js"></script>
  <script type="module" defer src="${pageContext.request.contextPath}/resources/js/board/review/review.js"></script>
</head>
<body>
<main>
  <jsp:include page="/WEB-INF/jsp/common/header.jsp"/>

  <section>
    <jsp:include page="/WEB-INF/jsp/board/accademy_info.jsp"/>
    <jsp:include page="/WEB-INF/jsp/board/accademy_review.jsp"/>
  </section>


  <jsp:include page="/WEB-INF/jsp/common/footer.jsp"/>
  <jsp:include page="/WEB-INF/jsp/common/bottom_menu.jsp"/>
  <div class="book-wrapper">
    <div class="book-container">
      <button id="bookBtn" class="btn btn-warning">예약하기 (0/20)</button>
    </div>
  </div>
</main>
</body>
</html>