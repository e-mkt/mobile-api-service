package me.training.mobileapiservice

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.math.BigDecimal
import java.util.UUID

@Component
@FeignClient(name = "sales", url = "http://localhost:9000/")
interface SellingServiceClient {
    @PostMapping(value = ["/sales"])
    fun createSale(@RequestBody createSaleDTO: CreateSaleRequest): CreateSaleResponse
}

data class CreateSaleRequest(
    val totalAmount: BigDecimal
)

data class CreateSaleResponse(
    val id: UUID,
    val items: List<SaleItemResponse>,
    val totalAmount: BigDecimal
)

data class SaleItemResponse(
    val code: String
)