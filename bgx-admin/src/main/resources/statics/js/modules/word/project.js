$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'word/project/list',
        datatype: "json",
        colModel: [			
			{ label: 'pId', name: 'pId', index: 'p_id', width: 50,key: true },
            { label: '项目状态 ', name: 'pStatus', index: 'p_status',
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
            { label: '项目结束时间 ', name: 'endTime', index: 'end_time' },
            { label: '项目开始时间 ', name: 'startTime', index: 'start_time' },
			{ label: '项目地址 ', name: 'pAddresss', index: 'p_addresss' }, 			
			{ label: '栏标价 ', name: 'pColumnPrice', index: 'p_column_price' }, 			
			{ label: '合同url ', name: 'pContract', index: 'p_contract' }, 			
			{ label: '分包单位 ', name: 'pContractCom', index: 'p_contract_com' }, 			
			{ label: '推包工侠（1是，0否） ', name: 'pIsPushLabor', index: 'p_is_push_labor' }, 			
			{ label: '推项目(1是，0否) ', name: 'pIsPushProject', index: 'p_is_push_project' }, 			
			{ label: '发包方项目名称 ', name: 'pName', index: 'p_name' }, 			
			{ label: '施工人数 ', name: 'pNum', index: 'p_num' }, 			
			{ label: '项目编号 ', name: 'pNumber', index: 'p_number' }, 			
			{ label: '备注 ', name: 'pRemark', index: 'p_remark' }, 			
			{ label: '项目规模 ', name: 'pScale', index: 'p_scale' },
			{ label: '工程类型 ', name: 'pType', index: 'p_type' }, 			
			{ label: '发包方项目类型（1：个人 、2：发包方（工程）） ', name: 'projectType', index: 'project_type' }, 			
			{ label: '地区编码 ', name: 'region', index: 'region' },
            { label: '发包方id ', name: 'cId', index: 'c_id' }
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
		project: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.project = {};
		},
		update: function (event) {
			var pId = getSelectedRow();
			if(pId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(pId)
		},
		saveOrUpdate: function (event) {
			var url = vm.project.pId == null ? "word/project/save" : "word/project/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.project),
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
			var pIds = getSelectedRows();
			if(pIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "word/project/delete",
                    contentType: "application/json",
				    data: JSON.stringify(pIds),
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
		getInfo: function(pId){
			$.get(baseURL + "word/project/info/"+pId, function(r){
                vm.project = r.project;
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