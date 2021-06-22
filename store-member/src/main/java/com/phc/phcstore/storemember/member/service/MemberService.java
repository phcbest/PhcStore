package com.phc.phcstore.storemember.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phc.phcbstort.common.utils.PageUtils;
import com.phc.phcstore.storemember.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author phcbest
 * @email phcbest2017@outlook.com
 * @date 2021-06-22 12:17:04
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

