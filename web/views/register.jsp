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
                <form method="post" action="/register" id="register-form" class="needs-validation" novalidate>
                    <div class="form-group">
                        <label for="name-register">Name</label>
                        <div class="input-group">
                            <input type="name" class="form-control" id="name-register" name="name"
                                   placeholder="Name" maxlength="255" autocomplete="off" required>
                            <div class="invalid-tooltip">
                                Please enter your name.
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email-register">Email address</label>
                        <div class="input-group">
                            <input type="email" class="form-control" id="email-register" name="email"
                                   autocomplete="off" placeholder="Email" required>
                            <div class="invalid-tooltip">
                                Please enter your email.
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password-register">Password</label>
                        <div class="input-group">
                            <input type="password" class="form-control" id="password-register"  name="password"
                                   placeholder="Password" required autocomplete="off" minlength="8"
                                   pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$">
                            <small class="form-text text-muted">
                                *Must be 8 characters long. Must have at least one digit, one uppercase letter, one lowercase letter, and one symbol.
                            </small>
                            <div class="invalid-tooltip">
                                Please enter a password.
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirm-password-register">Confirm Password</label>
                        <div class="input-group">
                            <input type="password" class="form-control" id="confirm-password-register" name="confirm-password"
                                   placeholder="Confirm Password" required autocomplete="off" minlength="8"
                                   pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$">
                            <div class="invalid-tooltip">
                                Please confirm your password and ensure it matches the password above.
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-dark" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-dark" id="register-submit-button">Register</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>