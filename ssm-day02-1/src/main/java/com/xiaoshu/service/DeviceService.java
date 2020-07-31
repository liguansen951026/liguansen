package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.DeviceMapper;
import com.xiaoshu.dao.TypeMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Device;
import com.xiaoshu.entity.Type;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class DeviceService {

	@Autowired
	UserMapper userMapper;

	@Autowired
	private DeviceMapper dm;
	
	@Autowired
	private TypeMapper tm;
	// 查询所有
	public List<User> findUser(User t) throws Exception {
		return userMapper.select(t);
	};

	// 数量
	public int countUser(User t) throws Exception {
		return userMapper.selectCount(t);
	};

	// 通过ID查询
	public User findOneUser(Integer id) throws Exception {
		return userMapper.selectByPrimaryKey(id);
	};

	// 新增
	public void addDevice(Device t) throws Exception {
		dm.addDevice(t);
	};

	// 修改
	public void updateDevice(Device t) throws Exception {
		dm.updateByPrimaryKeySelective(t);
	};

	// 删除
	public void deleteDevice(Integer id) throws Exception {
		dm.deleteByPrimaryKey(id);
	};

	// 登录
	public User loginUser(User user) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPasswordEqualTo(user.getPassword()).andUsernameEqualTo(user.getUsername());
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};

	// 通过用户名判断是否存在，（新增时不能重名）
	public Device existDeviceWithDeviceName(String deviceName) throws Exception {
		
		List<Device> deviceList = dm.findByName(deviceName);
		return deviceList.isEmpty()?null:deviceList.get(0);
	};

	// 通过角色判断是否存在
	public User existUserWithRoleId(Integer roleId) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(roleId);
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	}

	public PageInfo<Device> findDevicePage(Device device, int pageNum, int pageSize, String ordername, String order) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<Device> deviceList = dm.findAll(device);
		PageInfo<Device> pageInfo = new PageInfo<Device>(deviceList);
		return pageInfo;
	}

	public List<Type> findType() {
		List<Type> list = tm.selectAll();
		return list;
	}


}
