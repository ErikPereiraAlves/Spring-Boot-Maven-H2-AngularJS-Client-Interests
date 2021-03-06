

<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Specific User</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">


                    <input type="hidden" ng-model="ctrl.userId" />


                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="userName">Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.userName" id="userName" class="form-control input-sm" placeholder="Enter Name" required="true" ng-minlength="3" />
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="userLimitCredit">Credit Limit</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.userLimitCredit" id="userLimitCredit" class="form-control input-sm" placeholder="Enter credit Limit " required="true" ng-pattern="ctrl.onlyNumbers" />
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="userRisk">Risk (A,B or C)</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.userRisk" id="userRisk" class="form-control input-sm" placeholder="Enter Risk"  required="true" ng-minlength="1" />
                            </div>
                        </div>
                    </div>



                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.userId ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine" />
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Users</span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>CREDIT LIMIT</th>
                        <th>RISK</th>
                        <th>INTEREST (JUROS)</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrl.getAllUsers()">
                        <td>{{u.userId}}</td>
                        <td>{{u.userName}}</td>
                        <td>{{u.userLimitCredit}}</td>
                        <td>{{u.userRisk}}</td>
                        <td>{{u.userInterest}}</td>
                        <td><button type="button" ng-click="ctrl.editUser(u.userId)" class="btn btn-success custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrl.removeUser(u.userId)" class="btn btn-danger custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
