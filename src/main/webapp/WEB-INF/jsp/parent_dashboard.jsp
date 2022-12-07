<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <title>Dashboard</title>

    <jsp:include page="include/header.jsp" />

    <body style="font-family: FredokaOne; background-color: #EFF3F3;">
      <div class="d-flex vh-100 flex-column">
        <jsp:include page="include/navbar.jsp" />
        <div class="container w-75 my-3">
          <div class="row m-1 fs-1">
            <p> Welcome <span class="text-warning">${user.firstName}</span>! </p>
          </div>
          <div class="row">
            <div class="col-8">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Students Riding Today</h5>
                  <div class="accordion" id="accordionExample">
                    <div class="accordion-item">
                      <h2 class="accordion-header" id="headingTwo">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                          data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                          Accordion Item #2
                        </button>
                      </h2>
                      <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo"
                        data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                          <strong>This is the second item's accordion body.</strong> It is hidden by default, until the
                          collapse plugin adds the appropriate classes that we use to style each element. These classes
                          control the overall appearance, as well as the showing and hiding via CSS transitions. You can
                          modify any of this with custom CSS or overriding our default variables. It's also worth noting
                          that just about any HTML can go within the <code>.accordion-body</code>, though the transition
                          does limit overflow.
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-4">
              <div class="card">
                <div class="card-body container text-center">
                  <div class="row">
                    <div class="col">
                      <h5 class="card-title fs-4">All Students</h5>
                    </div>
                    <div class="col">
                      <a class="btn btn-warning" href="/parent/addstudent">+ Add Student</a>
                    </div>
                  </div>
                  <c:if test="${empty students}">
                    No students currently registered
                  </c:if>
                  <c:if test="${not empty students}">
                    <div class="list-group mx-3 my-3">
                      <c:forEach items="${students}" var="student">
                        <a href="#" class="list-group-item list-group-item-action text-start">${student.firstName}
                          ${student.lastName}</a>
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