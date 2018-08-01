var controllerUrl = $('#controllerUrl').val();

/**
 * 审核
 */
function updateByOverStatus() {
    var ids = getSelectedRows();
    if (ids == null) {
        return;
    }
    layer.prompt({
        title: '审核信息',
        formType: 2,
        btn: ['通过', '不通过', '取消'],

        yes: function (index, layero) {
            //按钮【通过】的回调
            $.ajax({
                type: "POST",
                contentType: "application/json;charset=UTF-8",
                dataType: 'json',
                url: baseURL + "word/" + controllerUrl + "/updateByOverStatus",
                data: JSON.stringify({ids: "" + ids, content: $(".layui-layer-input").val(), status: 1}),
                success: function (r) {
                    if (r.code == 0) {
                        alert('操作成功', function (index) {
                            $("#jqGrid").trigger("reloadGrid");
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });

            // 关闭
            layer.close(index);
        },
        btn2: function (index, layero) {
            //按钮【不通过】的回调
            $.ajax({
                type: "POST",
                contentType: "application/json;charset=UTF-8",
                dataType: 'json',
                url: baseURL + "word/" + controllerUrl + "/updateByOverStatus",
                data: JSON.stringify({ids: "" + ids, content: $(".layui-layer-input").val(), status: 0}),
                success: function (r) {
                    if (r.code == 0) {
                        alert('操作成功', function (index) {
                            $("#jqGrid").trigger("reloadGrid");
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });

            // 关闭
            layer.close(index);
        },
        cancel: function () {
            //右上角关闭回调
        }
    });
}

/**
 * 全部审核通过
 */
function updateByOverStatusSuccess() {
    layer.prompt({
            title: '一键审核通过',
            btn: ['通过', '取消'],
            formType: 2,
        },
        function (text, index) {
            $.ajax({
                type: "POST",
                contentType: "application/json;charset=UTF-8",
                dataType: 'json',
                url: baseURL + "word/" + controllerUrl + "/updateByOverStatus",
                data: JSON.stringify({content: $(".layui-layer-input").val(), status: 1}),
                success: function (r) {
                    if (r.code == 0) {
                        alert('操作成功', function (index) {
                            $("#jqGrid").trigger("reloadGrid");
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
            // 关闭
            layer.close(index);
        });
}

/**
 * 全部审核不通过
 */
function updateByOverStatusFailure() {
    layer.prompt({
            title: '一键审核不通过',
            btn: ['不通过', '取消'],
            formType: 2,
        },
        function (text, index) {
            $.ajax({
                type: "POST",
                contentType: "application/json;charset=UTF-8",
                dataType: 'json',
                url: baseURL + "word/" + controllerUrl + "/updateByOverStatus",
                data: JSON.stringify({content: $(".layui-layer-input").val(), status: 0}),
                success: function (r) {
                    if (r.code == 0) {
                        alert('操作成功', function (index) {
                            $("#jqGrid").trigger("reloadGrid");
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
            // 关闭
            layer.close(index);
        });
}

/**
 * 初始化
 */
function updateByOverStatusDefault() {
    $.ajax({url: baseURL + "word/" + controllerUrl + "/updateByOverStatusDefault", async: false});
    vm.reload();
};