<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 04/08/2019
  Time: 02:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <%--Head start--%>
    <c:set var="pageTitle" scope="request" value="Index"/>
    <jsp:include page="inc/head.jsp"></jsp:include>
    <%--Head end--%>

    <%--Body start--%>
    <body>
        <%--Start header--%>
        <jsp:include flush="true" page="inc/header.jsp"></jsp:include>
        <%--End header--%>

        <%--Start main--%>
        <main class="bg-light  pt-5">
            <div class="container-fluid">
                <%--Start alerts--%>
                <c:if test="${errors != null}">
                    <c:if test="${errors.size() != 0}">
                        <c:forEach items="${errors}" var="error">
                            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                ${error}
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </c:forEach>
                    </c:if>
                </c:if>
                <c:if test="${success != null}">
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                            ${success}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <c:if test="${info != null}">
                    <div class="alert alert-info alert-dismissible fade show" role="alert">
                            ${info}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <%--End alerts--%>
                <div class="card mb-4">
                    <div class="card-body">
                        <div class="card-title">
                            <h1 class="text-center mb-3">Check vulnerabilities in your code with TheReviewer</h1>
                        </div>
                        <div class="row">
                            <div class="col-md-8 col-sm-12 col-lg-8">
                                <h3 class="card-subtitle text-muted mb-3">Paste your code below for review</h3>
                                <form method="post" action="/review-code">
                                    <div class="form-group shadow-textarea">
                                        <textarea class="form-control z-depth-1" rows="13" name="input"
                                                  placeholder="Paste your code here..."></textarea>
                                    </div>
                                    <c:choose>
                                        <c:when test="${1 == 1}">
                                            <a href="#" class="btn btn-dark" data-toggle="modal" data-target="#signupPromptModal">Submit</a>
                                        </c:when>
                                        <c:otherwise>
                                            <button type="submit" class="btn btn-dark">Submit</button>
                                        </c:otherwise>
                                    </c:choose>

                                </form>
                            </div>
                            <div class="col-md-4 col-lg-4 col-sm-12">
                                <h3 class="card-subtitle text-muted  mb-3">Your code reviews</h3>
                                <div class="code-reviews">
                                <c:choose>
                                    <c:when test="${1 == 1}">
                                            <img src="../images/no_code.png" alt="No code reviews"
                                                 title="No code reviews" class="img-thumbnail">
                                    </c:when>
                                    <c:otherwise>
                                        <ul class="list-group">
                                            <li class="list-group-item">Code review 1</li>
                                            <li class="list-group-item">Code review 2</li>
                                            <li class="list-group-item">Code review 3</li>
                                            <li class="list-group-item">Code review 4</li>
                                        </ul>
                                    </c:otherwise>
                                </c:choose>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <%--End main--%>

        <%--Start footer--%>
        <jsp:include flush="true" page="inc/footer.jsp"></jsp:include>
        <%--End footer--%>

        <%--Modals--%>
        <jsp:include flush="true" page="editProfile.jsp"></jsp:include>
        <jsp:include flush="true" page="deleteAccount.jsp"></jsp:include>
        <jsp:include flush="true" page="register.jsp"></jsp:include>
        <jsp:include flush="true" page="login.jsp"></jsp:include>
        <jsp:include flush="true" page="signupPrompt.jsp"></jsp:include>
        <%--End modals--%>
    </body>
    <%--Body end--%>
</html>
