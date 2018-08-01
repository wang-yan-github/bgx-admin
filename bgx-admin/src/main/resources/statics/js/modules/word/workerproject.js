$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'word/workerproject/list',
        datatype: "json",
        colModel: [			
			{ label: 'wPId', name: 'wPId', index: 'w_p_id', width: 50, key: true },
            { label: '包工侠、劳务项目状态 ', name: 'wStatus', index: 'w_status',
                formatter: function (cellvalue, options, rowObject) {
                    if (cellvalue == "202") {return "<font color='#5bc0de'>信息待审核</font>";}
                    if (cellvalue == "203") {return "<font color='#5cb85c'>信息审核已通过</font>";}
                    if (cellvalue == "204") {return "<font color='#f0ad4e'>信息审核未通过</font>";}
                    if (cellvalue == "318") {return "<font color='#5bc0de'>完工待审核</font>";}
                    if (cellvalue == "319") {return "<font color='#5cb85c'>完工已通过</font>";}
                    if (cellvalue == "317") {return "<font color='#f0ad4e'>完工未通过</font>";}
                    else{return cellvalue;}
                }
            },
            { label: '类型 ', name: 'type', index: 'type',
                formatter: function (cellvalue, options, rowObject) {
                    if (cellvalue == "1") {return "<font color='#8b4513'>包工侠</font>";}
                    if (cellvalue == "2") {return "<font color='#337ab7'>劳务</font>";}
                    else{return cellvalue;}
                }
            },
            { label: '推劳务 ', name: 'wIsPushWorker', index: 'w_is_push_worker',
                formatter: function (cellvalue, options, rowObject) {
                    if (cellvalue == "1") {return "<font color='green'>是</font>";}
                    if (cellvalue == "2") {return "<font color='gray'>否</font>";}
                    else{return cellvalue;}
                }
            },
			{ label: '项目新增时间 ', name: 'addTime', index: 'add_time', width: 80 }, 			
			{ label: '合同id(对应合同表) ', name: 'ctId', index: 'ct_id', width: 80 }, 			
			{ label: '项目备案号 ', name: 'recordNumber', index: 'record_number', width: 80 }, 			
			{ label: '发包方项目id ', name: 'wProjectId', index: 'w_project_id', width: 80 },
			{ label: '包工侠、劳务、劳务公司id ', name: 'wWorkerId', index: 'w_worker_id', width: 80 },
			{ label: '包工侠项目id ', name: 'wWorkerProjectId', index: 'w_worker_project_id', width: 80 }, 			
			{ label: '劳务公司项目id ', name: 'wsProjectId', index: 'ws_project_id', width: 80 }			
        ],
        shrinkToFit:false,
        autoScroll: true,
        viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	//$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		workerProject: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.workerProject = {};
		},
		update: function (event) {
			var wPId = getSelectedRow();
			if(wPId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(wPId)
		},
		saveOrUpdate: function (event) {
			var url = vm.workerProject.wPId == null ? "word/workerproject/save" : "word/workerproject/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.workerProject),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var wPIds = getSelectedRows();
			if(wPIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "word/workerproject/delete",
                    contentType: "application/json",
				    data: JSON.stringify(wPIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(wPId){
			$.get(baseURL + "word/workerproject/info/"+wPId, function(r){
                vm.workerProject = r.workerProject;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});