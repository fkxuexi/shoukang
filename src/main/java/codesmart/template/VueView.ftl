<template>
    <div class="content">
        <!--搜索区域-->
        <div class="search">
            <div class="search-input  fl">
                <el-input placeholder="用户编号" v-model="search.nickname">
                    <i slot="prefix" class="el-input__icon el-icon-search"></i>
                </el-input>
            </div>
            <div class="search-button fl">
                <el-button type="primary" icon="el-icon-search" @click="getData">搜索</el-button>
                <el-button type="primary" icon="el-icon-plus" @click="showAddDialog">添加</el-button>
            </div>
            <div class="cl"></div>
        </div>
        <!--数据表-->
        <div class="table">
            <ex-table :colData="colData" :colModel="colModel"></ex-table>
        </div>
        <!--分页-->
        <div class="pagination" v-if="totalRecord > search.pageSize">
            <el-row>
                <el-col :span="10" :offset="7">
                    <el-pagination layout="prev, pager, next" :total="totalRecord" @current-change="page" :current-page="pageIndex" :page-size="search.pageSize" prev-text="上一页" next-text="下一页">
                    </el-pagination>
                </el-col>
            </el-row>
        </div>
        <iDialog :colModel="colModel" :dialog="dialog" @insert="insert"></iDialog>
    </div>
</template>
<script>
    import ExTable from '../../components/table/ExTable'
    import IDialog from  '../../components/dialog/Dialog'
    export default {
        components: {
            ExTable,
            IDialog,
        },
        mounted: function() {
            this.url.listUrl = this.colModel[this.colModel.length-1]['listUrl'];
            this.url.updateUrl = this.colModel[this.colModel.length-1]['updateUrl'];
            this.url.deleteUrl = this.colModel[this.colModel.length-1]['deleteUrl'];
            this.getData();
        },
        methods: {
            showAddDialog(){
                this.dialog.visual = true;
            },
            page(index) {
                this.search.pageIndex = index;
                this.getData();
            },
            getData() {
                this.$ajax.post(this.url.listUrl, this.search).then(res => {
                    if (res.data.state) {
                        var resData = res.data.obj;
                        this.colData = resData.list;
                        this.totalRecord = resData.total;
                    } else {
                        this.$utils.msg(this, "网络请求失败，请您稍后再试，谢谢您的配合", "error")
                        console.error(res);
                    }
                }).catch(error => {
                    this.$utils.msg(this, "网络请求失败，请您稍后再试，谢谢您的配合", "error")
                })
            },
            insert(data){
                this.$ajax.post(this.url.updateUrl, data).then(res => {
                    if (res.data.state){
                    this.$utils.msg(this,'添加成功','success');
                    this.colData.splice(0,0,res.data.obj);
                    this.dialog.visual=false;
                }else{
                    this.$utils.msg(this,'添加失败','error');
                }
                }).catch(error=>{
                    this.$utils.msg(this,'添加失败','error');
                })
            }
        },
        data() {
            return {
                colData: [],
                pageIndex: 1,
                totalRecord: 0,
                search: {
                    nickname: '',
                    pageIndex: 1,
                    pageSize: 20,
                },
                dialog:{
                    visual:false,
                    title:'用户添加',
                    width:'80%',
                },
                url:{
                    listUrl:'',
                    updateUrl:'',
                    deletUrl:'',
                },
                colModel: [
                <#list data.allColList!as col >
                    {
                        label: '${col.javaAttrName}',
                        attr: '${col.javaAttrName}',
                        show:true,
                        ex_show:true,
                        write:true,
                        add:true,
                        type:'simple',
                        ext:'',
                        width: 120,
                        formatter: '',
                    },
                </#list>
                    {
                        label: '操作',
                        width: 120,
                        ex_show: false,
                        type: 'action',
                        children: [{ action: 'update' }, { action: 'delete' }]
                    },{
                        type:'action',
                        listUrl:'',
                        updateUrl:'',
                        deleteUrl:''
                    }

                ]
            }
        }
    }
</script>