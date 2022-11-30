<jsp:include page="include/header.jsp"/>
<body>
  <div class="d-flex vh-100 flex-column" style="overflow: hidden; position: relative;">
      <img src="../../../images/bus-bg.jpg" alt="" style="opacity: 0.6;
      position: absolute;
      left: 0;
      top: 0;
      width: 100%;
      height: auto;">
    <jsp:include page="include/navbar.jsp"/>
      <div class="border align-self-center shadow rounded p-3 my-auto bg-light container w-50" style="position: relative;">
        <h1 class="text-center mb-5 mt-3">Welcome to SimpleBus!</h1>
        <p class="text-center">
            SimpleBus is an easy to use software for both parents and drivers to easily manage bus routes and students. 
            Parents are abke to track buses to ensure that their child arrives safely at home. Drivers can also optimize their 
            by knowing what students will be riding each day. Simplify the school bus experience today by signing up or logging
            in below!
        </p>
        <div class="row mt-5 mb-4">
            <div class="col text-end">
                <a class="btn btn-warning w-50" href="login.jsp" role="button">Login</a>
            </div>
            <div class="col text-start">
                <a class="btn btn-warning w-50" href="/signup" role="button">Sign Up</a>
            </div>
        </div>
      </div>
    </div>
  </body>
</html>
