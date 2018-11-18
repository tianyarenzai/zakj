package com.zakj.personnel.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zakj.personnel.entity.SmdCeAttachmentEntity;
import com.zakj.personnel.service.SmdCeAttachmentService;
import com.zakj.utils.PageUtils;
import com.zakj.utils.Query;
import com.zakj.utils.R;
/**
 * InnoDB free: 12288 kB; (`contract_id`) REFER `renren_fast/smd_ce_contract`(`cont
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@RestController
@RequestMapping("/employee/smdceattachment")
public class SmdCeAttachmentController {
	@Autowired
	private SmdCeAttachmentService smdCeAttachmentService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Map<String, Object>> smdCeAttachmentList = smdCeAttachmentService.queryList(query);
		int total = smdCeAttachmentService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(smdCeAttachmentList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{attachmentId}")
	public R info(@PathVariable("attachmentId") String attachmentId){
		SmdCeAttachmentEntity smdCeAttachment = smdCeAttachmentService.queryObject(attachmentId);
		
		return R.ok().put("smdCeAttachment", smdCeAttachment);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody SmdCeAttachmentEntity smdCeAttachment){
		smdCeAttachmentService.save(smdCeAttachment);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody SmdCeAttachmentEntity smdCeAttachment){
		smdCeAttachmentService.update(smdCeAttachment);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody String[] attachmentIds){
		smdCeAttachmentService.deleteBatch(attachmentIds);
		
		return R.ok();
	}
	
}
