//添加用户成功后需要给用户添加一个默认的收货地址
            setUpUserDefaultAddr(userParam.getDoctorUid(),up.getUid());
        }
        return responseParam;
    }

    private void setUpUserDefaultAddr(String doctorUid,String uid) {
        ThreadManager.SynchronousQueue(UserService.class).submit(() -> {
            try{
                //根据uid查询医生信息
                UserInfoFormBean doctorInfo = doctorServiceApi.getUserInfoFormBeanByUid(doctorUid);
                if(!CheckNull.isNull(doctorInfo) && !CheckNull.isNull(doctorInfo.getName()) && !CheckNull.isNull(doctorInfo.getPhone()) && !CheckNull.isNull(doctorInfo.getHomeAddress())
                        && !CheckNull.isNull(doctorInfo.getProvince()) && !CheckNull.isNull(doctorInfo.getCity()) && !CheckNull.isNull(doctorInfo.getArea())){
                    ShippingAddress sa = new ShippingAddress();
                    sa.setId(UUIDGenerator.getUUID());
                    sa.setConsignee(doctorInfo.getName());
                    sa.setCity(doctorInfo.getCity());
                    sa.setPhone(doctorInfo.getPhone());
                    sa.setCounty(doctorInfo.getArea());
                    sa.setCreateTime(new Date());
                    sa.setDefaultAddr(1);
                    sa.setDetailAddr(doctorInfo.getHomeAddress());
                    sa.setProvince(doctorInfo.getProvince());
                    sa.setUpdateTime(new Date());
                    sa.setUid(uid);
                    sa.setDoctorUid(doctorUid);
                    shippingAddressService.insertNonEmptyShippingAddress(sa);
                }
            }catch (Exception e){
                logger.info("设置用户默认收货地址出错");
                e.printStackTrace();
            }
        });
    }