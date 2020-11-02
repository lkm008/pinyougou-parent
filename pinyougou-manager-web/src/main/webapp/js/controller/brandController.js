//控制层
app.controller('brandController',function ($scope, brandService) {
    //读取列表数据绑定到表单中
    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
            );
    }
    //重新加载列表 数据
    $scope.reloadList = function () {
        //切换页码
        $scope.search($scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage);
    };
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };
    //分页
    $scope.findPage = function (page, rows) {
        brandService.findPage(page,rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };
    //查询实体
    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    };

    //保存
    $scope.save = function () {
		var serviceObject;//服务层对象
        if ($scope.entity.id != null) {//如果有 ID
			serviceObject=brandService.update( $scope.entity ); //修改
		}else{
			serviceObject=brandService.add( $scope.entity  );//增加
        }
		serviceObject.success(
            function (response) {
                if (response.success) {
                    //重新查询
                    $scope.reloadList();//重新加载
                } else {
                    alert(response.message);
                }

            }
        )
    };

    $scope.selectIds = [];//选中的 ID 集合
//更新复选
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {//如果是被选中,则增加到数组
            $scope.selectIds.push(id);
        } else {
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除
        }
    };
//批量删除
    $scope.dele = function () {
//获取选中的复选框
        brandService.dele($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//刷新列表
					$scope.selectIds=[];
                }
            }
        );
    };
    $scope.searchEntity = {};//定义搜索对象
//条件查询
    $scope.search = function (page, rows) {
        brandService.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;//给列表变量赋值
                $scope.paginationConf.totalItems = response.total;//总记录数
            }
        );
    };
})