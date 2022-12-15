<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <title>Admin Dashboard</title>

        <jsp:include page="include/header.jsp" />

        <body style="font-family: FredokaOne; background-color: #EFF3F3;">
            <div class="d-flex vh-100 flex-column">
                <jsp:include page="include/navbar.jsp" />
                <div class="container w-75 my-3">
                    <div class="row m-1 fs-1">
                        <p> Welcome <span class="text-warning">${user.firstName}</span>! </p>
                    </div>
                    <div class="row m-2">
                        <div class="col">
                            <div class="card text-center">
                                <div class="card-header">
                                    Route Management
                                </div>
                                <div class="card-body">
                                    <p class="card-text">Manage route information and status for your account.</p>
                                    <a href="/admin/addroute" class="btn btn-warning">Add New Route</a>
                                    <a href="/admin/resetroutes" class="btn btn-warning">Reset Routes</a>
                                    <a href="/admin/editroutes" class="btn btn-warning">Edit Routes</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="toast-container position-fixed bottom-0 end-0 p-3">
                <div id="resetToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                  <div class="toast-header">
                    <strong class="me-auto">Reset Routes</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                  </div>
                  <div class="toast-body">
                    All routes and stops have been reset
                  </div>
                </div>
              </div>
              
        </body>

        <script>
            if (${success}){
                const toast = new bootstrap.Toast(document.getElementById('resetToast'));
                toast.show();
            }
        </script>

<jsp:include page="include/footer.jsp" />