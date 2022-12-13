<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <title>Dashboard</title>

    <jsp:include page="include/header.jsp" />

    <body style="font-family: FredokaOne; background-color: #EFF3F3;">
      <div class="d-flex vh-100 flex-column">
        <jsp:include page="include/navbar.jsp" />
        <div class="container w-50 my-3">
          <div class="row m-1 fs-1">
            <p> Welcome <span class="text-warning">${user.firstName}</span>!</p>
          </div>
          <div class="row">
            <div class="col">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Today's Route(s)</h5>
                  <c:if test="${empty routes}">
                    No routes today
                  </c:if>
                  <c:if test="${not empty routes}">
                    <div class="list-group mx-3 my-3">
                      <c:forEach items="${routes}" var="route">
                        <a href="/driver/route/${route.id}"
                          class="list-group-item list-group-item-action text-start">${route.name}</a>
                      </c:forEach>
                    </div>
                  </c:if>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </body>

    </html>