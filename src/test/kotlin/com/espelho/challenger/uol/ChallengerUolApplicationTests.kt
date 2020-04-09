package com.espelho.challenger.uol

import com.espelho.challenger.uol.entities.GiftEntity
import com.espelho.challenger.uol.entities.PriceRuleEntity
import com.espelho.challenger.uol.entities.ProductEntity
import com.espelho.challenger.uol.entities.ShippingCompanyEntity
import com.espelho.challenger.uol.services.PriceRuleService
import com.espelho.challenger.uol.services.SendService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.ui.context.support.UiApplicationContextUtils
import java.util.*
import kotlin.collections.ArrayList

@SpringBootTest
class ChallengerUolApplicationTests(@Autowired val priceRuleService: PriceRuleService,
                                    @Autowired val sendService: SendService) {

    @Test
    public fun testPriceRuleAccept() {
        val shippingCompany: ShippingCompanyEntity = ShippingCompanyEntity(UUID.randomUUID(), "Teste")
        val priceRules: ArrayList<PriceRuleEntity> = ArrayList()
        priceRules.add(PriceRuleEntity(UUID.randomUUID(),
                shippingCompany,
                0.0,
                4.999,
                10.0,
                1.0))
        Assertions.assertEquals(1, this.priceRuleService.getPriceRules(priceRules, 1.0).size)
    }

    @Test
    public fun testPriceRuleReject() {
        val shippingCompany: ShippingCompanyEntity = ShippingCompanyEntity(UUID.randomUUID(), "Teste")
        val priceRules: ArrayList<PriceRuleEntity> = ArrayList()
        priceRules.add(PriceRuleEntity(UUID.randomUUID(),
                shippingCompany,
                5.0,
                Double.MAX_VALUE,
                10.0,
                1.0))
        Assertions.assertEquals(0, this.priceRuleService.getPriceRules(priceRules, 1.0).size)
    }

    @Test
    public fun testCalculateSend() {
        val shippingCompany: ShippingCompanyEntity = ShippingCompanyEntity(UUID.randomUUID(), "Teste")
        val priceRule: PriceRuleEntity = PriceRuleEntity(UUID.randomUUID(), shippingCompany, 0.0,
                Double.MAX_VALUE, 10.0, 0.05)
        val product: ProductEntity = ProductEntity(UUID.randomUUID(), "fone de ouvido", 1.0)
        val gift: GiftEntity = GiftEntity(UUID.randomUUID(), 1.0, product)
        Assertions.assertEquals(sendService.calculatePrice(gift, priceRule), 10.05)
    }


}
