package com.phc.phcstore.storemember.member.dao;

import com.phc.phcstore.storemember.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author phcbest
 * @email phcbest2017@outlook.com
 * @date 2021-06-22 12:17:04
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
