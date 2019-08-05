<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 05/08/2019
  Time: 05:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Modal -->
<div class="modal fade" id="uploadCodeModal" tabindex="-1" role="dialog" aria-labelledby="uploadCodeModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="uploadCodeModalLabel">Upload code for review</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="upload-code-form">
                    <div class="form-group">
                        <label for="file">Upload file</label>
                        <input type="file" class="form-control" id="file" required>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-dark" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-dark" id="upload-code-submit">Submit</button>
            </div>
        </div>
    </div>
</div>