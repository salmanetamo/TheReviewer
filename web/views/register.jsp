<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 05/08/2019
  Time: 05:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Modal -->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="registerModalLabel">Register</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="register-form">
                    <div class="form-group">
                        <label for="name-register">Name</label>
                        <div class="input-group">
                            <input type="name" class="form-control" id="name-register" placeholder="Name" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email-register">Email address</label>
                        <div class="input-group">
                            <input type="email" class="form-control" id="email-register" placeholder="Email" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password-register">Password</label>
                        <div class="input-group">
                            <input type="password" class="form-control" id="password-register" placeholder="Password" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirm-password-register">Confirm Password</label>
                        <div class="input-group">
                            <input type="password" class="form-control" id="confirm-password-register" placeholder="Confirm Password" required>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-dark" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-dark" id="register-submit-button">Register</button>
            </div>
        </div>
    </div>
</div>