package io.renren.modules.word.controller;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.sys.controller.AbstractController;
import io.renren.modules.word.entity.AuditorEntity;
import io.renren.modules.word.entity.CompanyEntity;
import io.renren.modules.word.entity.ProjectEntity;
import io.renren.modules.word.service.AuditorService;
import io.renren.modules.word.util.Constant;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.word.entity.ProjectEntity;
import io.renren.modules.word.service.ProjectService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 发包项目
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-18 10:52:01
 */
@RestController
@RequestMapping("word/project")
public class ProjectController extends AbstractController {
    @Autowired
    private ProjectService projectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("word:project:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = projectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{pId}")
    @RequiresPermissions("word:project:info")
    public R info(@PathVariable("pId") Long pId){
        ProjectEntity project = projectService.selectById(pId);

        return R.ok().put("project", project);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("word:project:save")
    public R save(@RequestBody ProjectEntity project){
        projectService.insert(project);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("word:project:update")
    public R update(@RequestBody ProjectEntity project){
        ValidatorUtils.validateEntity(project);
        projectService.updateAllColumnById(project);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("word:project:delete")
    public R delete(@RequestBody Long[] pIds){
        projectService.deleteBatchIds(Arrays.asList(pIds));

        return R.ok();
    }

}
