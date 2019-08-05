<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 05/08/2019
  Time: 05:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Modal -->
<div class="modal fade" id="editProfileModal" tabindex="-1" role="dialog" aria-labelledby="editProfileModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editProfileModalLabel">Edit profile</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="edit-profile-form">
                    <div class="form-group">
                        <label for="name-edit">Name</label>
                        <div class="input-group">
                            <input type="name" class="form-control" id="name-edit" placeholder="Name" required value="Old name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email-edit">Email address</label>
                        <div class="input-group">
                            <input type="email" class="form-control" id="email-edit" placeholder="Email" required value="Old email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password-edit">New Password</label>
                        <div class="input-group">
                            <input type="password" class="form-control" id="password-edit" placeholder="Password" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirm-password-edit">Confirm New Password</label>
                        <div class="input-group">
                            <input type="password" class="form-control" id="confirm-password-edit" placeholder="Confirm new Password" required>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-dark" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-dark" id="edit-profile-submit">Save changes</button>
            </div>
        </div>
    </div>
</div>