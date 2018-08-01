package io.renren.modules.word.controller;

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

import io.renren.modules.word.entity.WorkerProjectEntity;
import io.renren.modules.word.service.WorkerProjectService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-25 18:07:56
 */
@RestController
@RequestMapping("word/workerproject")
public class WorkerProjectController {
    @Autowired
    private WorkerProjectService workerProjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("word:workerproject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = workerProjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{wPId}")
    @RequiresPermissions("word:workerproject:info")
    public R info(@PathVariable("wPId") Long wPId){
        WorkerProjectEntity workerProject = workerProjectService.selectById(wPId);

        return R.ok().put("workerProject", workerProject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("word:workerproject:save")
    public R save(@RequestBody WorkerProjectEntity workerProject){
        workerProjectService.insert(workerProject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("word:workerproject:update")
    public R update(@RequestBody WorkerProjectEntity workerProject){
        ValidatorUtils.validateEntity(workerProject);
        workerProjectService.updateAllColumnById(workerProject);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("word:workerproject:delete")
    public R delete(@RequestBody Long[] wPIds){
        workerProjectService.deleteBatchIds(Arrays.asList(wPIds));

        return R.ok();
    }

}
