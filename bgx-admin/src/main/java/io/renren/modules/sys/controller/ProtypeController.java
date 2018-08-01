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

import io.renren.modules.sys.entity.ProtypeEntity;
import io.renren.modules.sys.service.ProtypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 项目类型
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-13 10:48:42
 */
@RestController
@RequestMapping("sys/protype")
public class ProtypeController {
    @Autowired
    private ProtypeService protypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:protype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = protypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:protype:info")
    public R info(@PathVariable("id") Integer id){
        ProtypeEntity protype = protypeService.selectById(id);

        return R.ok().put("protype", protype);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:protype:save")
    public R save(@RequestBody ProtypeEntity protype){
        protypeService.insert(protype);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:protype:update")
    public R update(@RequestBody ProtypeEntity protype){
        ValidatorUtils.validateEntity(protype);
        protypeService.updateAllColumnById(protype);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:protype:delete")
    public R delete(@RequestBody Integer[] ids){
        protypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
