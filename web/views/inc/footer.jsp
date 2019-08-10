<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 04/08/2019
  Time: 02:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer class="page-footer font-small bg-dark">
    <!-- Copyright -->
    <div class="footer-copyright text-center text-white">© 2019 Copyright:
        <a href="#" class="disabled text-white"> TheReviewer.com</a>
    </div>
    <!-- Copyright -->

    <%-- Scripts --%>
    <script type="text/javascript" src="../../js/script.js"></script>
    <c:if test="${registering != null}">
        <c:if test="${registering == true}">
            <script type="text/javascript">
                $(document).ready(function() {
                    $('#registerModalTrigger').click();
                });
            </script>
        </c:if>
    </c:if>
    <c:if test="${loggingIn != null}">
        <c:if test="${loggingIn == true}">
            <script type="text/javascript">
                $( document ).ready(function() {
                    $('#loginModalTrigger').click();
                });
            </script>
        </c:if>
    </c:if>
    <c:if test="${editingProfile != null}">
        <c:if test="${editingProfile == true}">
            <script type="text/javascript">
                $(document).ready(function() {
                    $('#editProfileModalTrigger').click();
                });
            </script>
        </c:if>
    </c:if>
    <c:if test="${deleteAccount != null}">
        <c:if test="${deleteAccount == true}">
            <script type="text/javascript">
                $(document).ready(function() {
                    $('#deleteAccountModalTrigger').click();
                });
            </script>
        </c:if>
    </c:if>
</footer>
