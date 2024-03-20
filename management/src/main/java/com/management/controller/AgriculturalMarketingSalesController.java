package com.management.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.management.entity.AgriculturalProduct;
import com.management.entity.AgriculturalProductPrice;
import com.management.entity.AgriculturalProductSales;
import com.management.entity.vo.AgriculturalProductSalesVo;
import com.management.service.AgriculturalProductPriceService;
import com.management.service.AgriculturalProductSalesService;
import com.management.service.impl.AgriculturalProductServiceImpl;
import com.management.utils.DateUtils;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author TokisakiKurumi
 * @className AgriculturalMarketingSalesController
 * @date 2024/3/12
 * @description
 **/
@RestController
@RequestMapping("/market")
public class AgriculturalMarketingSalesController {

    @Autowired
    private AgriculturalProductServiceImpl agriculturalProductService;

    @Autowired
    private AgriculturalProductSalesService agriculturalProductSalesService;

    @Autowired
    private AgriculturalProductPriceService agriculturalProductPriceService;

    /*农产品管理*/

    /*@GetMapping("/products/{pageNum}/{pageSize}")
    public AjaxResult getAllProducts(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageUtils.startPage(pageNum, pageSize);
        List<AgriculturalProduct> agriculturalProducts = agriculturalProductService.getBaseMapper().selectList(null);
        PageUtils.clearPage();
        if (!ObjectUtils.isEmpty(agriculturalProducts)) {
            agriculturalProducts.forEach(agriculturalProduct -> {
                agriculturalProduct.setExpirationDate(DateUtils.toFormatDate(agriculturalProduct.getExpirationDate()));
                agriculturalProduct.setHarvestDate(DateUtils.toFormatDate(agriculturalProduct.getHarvestDate()));
            });
            return AjaxResult.success("查询成功", agriculturalProducts);
        }
        return AjaxResult.error("查询失败");
    }*/

    @GetMapping("/products/{pageNum}/{pageSize}")
    public AjaxResult getProducts(@RequestParam("p") String productName,@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        QueryWrapper<AgriculturalProduct> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(productName)) {
            queryWrapper.like("product_name", productName);
        }
        PageUtils.startPage(pageNum, pageSize);
        List<AgriculturalProduct> agriculturalProducts = agriculturalProductService.getBaseMapper().selectList(null);
        PageUtils.clearPage();
        PageInfo<AgriculturalProduct> pageInfo = new PageInfo<>(agriculturalProducts);
        if (!ObjectUtils.isEmpty(agriculturalProducts)) {
            pageInfo.getList().forEach(agriculturalProduct -> {
                agriculturalProduct.setExpirationDate(DateUtils.toFormatDate(agriculturalProduct.getExpirationDate()));
                agriculturalProduct.setHarvestDate(DateUtils.toFormatDate(agriculturalProduct.getHarvestDate()));
            });
            return AjaxResult.success("查询成功", pageInfo);
        }
        return AjaxResult.error("查询失败");
    }

    @PostMapping("/products/insert")
    public AjaxResult insertProducts(@RequestBody List<AgriculturalProduct> agriculturalProducts) {
        return agriculturalProductService.insertProduct(agriculturalProducts) ? AjaxResult.success("插入成功") : AjaxResult.error("插入失败");
    }

    @PostMapping("/products/update")
    public AjaxResult updateProducts(@RequestBody AgriculturalProduct agriculturalProduct) {
        return agriculturalProductService.updateById(agriculturalProduct) ? AjaxResult.success("更新成功") : AjaxResult.error("更新失败");
    }

    @PostMapping("/products/delete")
    public AjaxResult deleteProducts(@RequestBody List<Integer> productIds) {
        return agriculturalProductService.removeBatchByIds(productIds) ? AjaxResult.success("删除成功") : AjaxResult.error("删除失败");
    }

    /*农产品推荐*/

    @GetMapping("/products/price/{pageNum}/{pageSize}")
    public AjaxResult getAllProductPrice(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageUtils.startPage(pageNum, pageSize);
        List<AgriculturalProductPrice> agriculturalProductPrices = agriculturalProductPriceService.getBaseMapper().selectList(null);
        PageUtils.clearPage();
        PageInfo<AgriculturalProductPrice> pageInfo = new PageInfo<>(agriculturalProductPrices);
        return !ObjectUtils.isEmpty(agriculturalProductPrices) ? AjaxResult.success("查询成功", pageInfo) : AjaxResult.error("查询失败");
    }

    @GetMapping("/products/price/{id}")
    public AjaxResult getProductPrice(@PathVariable("id") Integer productId) {
        QueryWrapper<AgriculturalProductPrice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id", productId);
        List<AgriculturalProductPrice> agriculturalProductPrices = agriculturalProductPriceService.getBaseMapper().selectList(queryWrapper);
        return !Objects.isNull(agriculturalProductPrices) ? AjaxResult.success("查询成功", agriculturalProductPrices) : AjaxResult.error("查询失败");
    }

    @PostMapping("/products/price")
    public AjaxResult getProductPrice(@RequestParam("w") String word) {
        List<AgriculturalProductPrice> productPrices = agriculturalProductService.findData(word);
        return !ObjectUtils.isEmpty(productPrices) ? AjaxResult.success("查询成功", productPrices) : AjaxResult.error("查询失败");
    }

    /*农产品销售*/

    @GetMapping("/products/sales/{pageNum}/{pageSize}")
    public AjaxResult getAllProductSales(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageUtils.startPage(pageNum, pageSize);
        List<AgriculturalProductSalesVo> agriculturalProductSales = agriculturalProductSalesService.getAll();
        PageUtils.clearPage();
        PageInfo<AgriculturalProductSalesVo> pageInfo = new PageInfo<>(agriculturalProductSales);
        if (!ObjectUtils.isEmpty(agriculturalProductSales)) {
            pageInfo.getList().forEach(agriculturalProductSale -> {
                agriculturalProductSale.setSaleDate(DateUtils.toFormatDate(agriculturalProductSale.getSaleDate()));
            });
            return AjaxResult.success("查询成功", pageInfo);
        }
        return AjaxResult.error("查询失败");
    }

    @GetMapping("/products/sales/{id}/{pageNum}/{pageSize}")
    public AjaxResult getProductSales(@PathVariable("id") Integer productId, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageUtils.startPage(pageNum, pageSize);
        List<AgriculturalProductSalesVo> agriculturalProductSales = agriculturalProductSalesService.getAgriculturalProductSales(productId);
        PageUtils.clearPage();
        PageInfo<AgriculturalProductSalesVo> pageInfo = new PageInfo<>(agriculturalProductSales);
        if (!ObjectUtils.isEmpty(agriculturalProductSales)) {
            pageInfo.getList().forEach(agriculturalProductSale -> {
                agriculturalProductSale.setSaleDate(DateUtils.toFormatDate(agriculturalProductSale.getSaleDate()));
            });
            return AjaxResult.success("查询成功", pageInfo);
        }
        return AjaxResult.error("查询失败");
    }


    @PostMapping("/products/sales/insert")
    public AjaxResult insertProductSales(@RequestBody List<AgriculturalProductSales> agriculturalProductSales) {
        return agriculturalProductSalesService.saveBatch(agriculturalProductSales) ? AjaxResult.success("插入成功") : AjaxResult.error("插入失败");
    }

    @PostMapping("/products/sales/update")
    public AjaxResult updateProductSales(@RequestBody AgriculturalProductSales agriculturalProductSales) {
        return agriculturalProductSalesService.updateById(agriculturalProductSales) ? AjaxResult.success("更新成功") : AjaxResult.error("更新失败");
    }

    @PostMapping("/products/sales/delete")
    public AjaxResult deleteProductSales(@RequestBody List<Integer> productSalesIds) {
        return agriculturalProductSalesService.removeBatchByIds(productSalesIds) ? AjaxResult.success("删除成功") : AjaxResult.error("删除失败");
    }
}
