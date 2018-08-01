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

import io.renren.modules.word.entity.AuditorEntity;
import io.renren.modules.word.service.AuditorService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 审核记录
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-18 17:04:45
 */
@RestController
@RequestMapping("word/auditor")
public class AuditorController {
    @Autowired
    private AuditorService auditorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("word:auditor:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = auditorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{aId}")
    @RequiresPermissions("word:auditor:info")
    public R info(@PathVariable("aId") Long aId){
        AuditorEntity auditor = auditorService.selectById(aId);

        return R.ok().put("auditor", auditor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("word:auditor:save")
    public R save(@RequestBody AuditorEntity auditor){
        auditorService.insert(auditor);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("word:auditor:update")
    public R update(@RequestBody AuditorEntity auditor){
        ValidatorUtils.validateEntity(auditor);
        auditorService.updateAllColumnById(auditor);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("word:auditor:delete")
    public R delete(@RequestBody Long[] aIds){
        auditorService.deleteBatchIds(Arrays.asList(aIds));

        return R.ok();
    }

}
