package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.MessageEntity;
import io.renren.modules.sys.service.MessageService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-11 10:40:49
 */
@RestController
@RequestMapping("sys/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:message:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = messageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:message:info")
    public R info(@PathVariable("id") Integer id){
        MessageEntity message = messageService.selectById(id);

        return R.ok().put("message", message);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:message:save")
    public R save(@RequestBody MessageEntity message){
        messageService.insert(message);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:message:update")
    public R update(@RequestBody MessageEntity message){
        ValidatorUtils.validateEntity(message);
        messageService.updateAllColumnById(message);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:message:delete")
    public R delete(@RequestBody Integer[] ids){
        messageService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
