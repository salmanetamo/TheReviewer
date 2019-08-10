<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 05/08/2019
  Time: 05:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Modal -->
<div class="modal fade" id="signupPromptModal" tabindex="-1" role="dialog" aria-labelledby="signupPromptModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="signupPromptModalLabel">Sign up Required</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>You need to sign up before you can use TheReviewer.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-dark" data-dismiss="modal">Close</button>
                <a href="/register" class="btn btn-danger btn-dark" >Sign up</a>
            </div>
        </div>
    </div>
</div>