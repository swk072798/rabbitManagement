package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RebbitIllnessRecord;
import java.util.List;

public interface RebbitIllnessRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rebbit_illness_record
     *
     * @mbg.generated
     */
    int insert(RebbitIllnessRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rebbit_illness_record
     *
     * @mbg.generated
     */
    List<RebbitIllnessRecord> selectAll();
}