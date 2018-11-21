package com.xjtu.pic_gradient.mapper;

import com.xjtu.pic_gradient.pojo.Photo;
import com.xjtu.pic_gradient.pojo.PhotoExample;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface PhotoMapper {

    @Select("select photoName from photo where ID=#{ID}")
    public String getPhotoName(Integer ID);

    int countByExample(PhotoExample example);

    int deleteByExample(PhotoExample example);

    int insert(Photo record);

    int insertSelective(Photo record);

    List<Photo> selectByExample(PhotoExample example);

    int updateByExampleSelective(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByExample(@Param("record") Photo record, @Param("example") PhotoExample example);

    @Select("select photoName from photo")
    List<String> getName();

    @Insert("insert into photo(photoName) values (#{name})")
    void insertPhotoName(String name);

    @Delete("DELETE FROM photo WHERE photo.photoName=#{name}")
    void deleteName(String name);
}