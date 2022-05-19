package me.training.mobileapiservice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("sales")
class SalesController(
    val sellingServiceClient: SellingServiceClient
) {
    @PostMapping
    fun createSale(@RequestBody createSaleDTO: CreateSaleDTO): ResponseEntity<SaleCreatedDTO> {
        val createSaleRequest = CreateSaleRequest(
            totalAmount = BigDecimal(createSaleDTO.amount)
        )
        val result = sellingServiceClient.createSale(createSaleRequest)

        return ResponseEntity.status(HttpStatus.CREATED).body(SaleCreatedDTO(
            employeeName = "Sample Name 1",
            totalAmount = result.totalAmount.toString()
        ))
    }
}

data class CreateSaleDTO(
    val amount: String
)

data class SaleCreatedDTO(
    val employeeName: String,
    val totalAmount: String
)
