package io.renren.modules.word.controller;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.sys.controller.AbstractController;
import io.renren.modules.word.entity.AuditorEntity;
import io.renren.modules.word.entity.WorkerEntity;
import io.renren.modules.word.service.AuditorService;
import io.renren.modules.word.util.Constant;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.word.entity.WorkerEntity;
import io.renren.modules.word.service.WorkerService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 劳务信息
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 3018-07-19 11:33:16
 */
@RestController
@RequestMapping("word/worker")
public class WorkerController extends AbstractController {
    @Autowired
    private WorkerService workerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("word:worker:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = workerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{wId}")
    @RequiresPermissions("word:worker:info")
    public R info(@PathVariable("wId") Long wId){
        WorkerEntity worker = workerService.selectById(wId);

        return R.ok().put("worker", worker);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("word:worker:save")
    public R save(@RequestBody WorkerEntity worker){
        workerService.insert(worker);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("word:worker:update")
    public R update(@RequestBody WorkerEntity worker){
        ValidatorUtils.validateEntity(worker);
        workerService.updateAllColumnById(worker);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("word:worker:delete")
    public R delete(@RequestBody Long[] wIds){
        workerService.deleteBatchIds(Arrays.asList(wIds));

        return R.ok();
    }

}
