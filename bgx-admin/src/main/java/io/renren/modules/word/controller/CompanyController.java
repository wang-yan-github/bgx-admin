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

import io.renren.modules.word.entity.CompanyEntity;
import io.renren.modules.word.service.CompanyService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-24 11:24:20
 */
@RestController
@RequestMapping("word/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("word:company:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = companyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{cId}")
    @RequiresPermissions("word:company:info")
    public R info(@PathVariable("cId") Long cId){
        CompanyEntity company = companyService.selectById(cId);

        return R.ok().put("company", company);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("word:company:save")
    public R save(@RequestBody CompanyEntity company){
        companyService.insert(company);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("word:company:update")
    public R update(@RequestBody CompanyEntity company){
        ValidatorUtils.validateEntity(company);
        companyService.updateAllColumnById(company);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("word:company:delete")
    public R delete(@RequestBody Long[] cIds){
        companyService.deleteBatchIds(Arrays.asList(cIds));

        return R.ok();
    }

}
