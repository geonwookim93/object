public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}

// 구현한 기능들을 한글말로 풀어보면 어느것이 이상한지 알 수 있다.
// 극장에 입장하는 과정을 보자
// 극장이 관중의 가방에서 초대장이 있는지 먼저 파악한다. 있으면 티켓 판매원이 근무하는 티켓 오피스에로 부터 티켓을 가져와 관중의 가방에 넣어준다.
// 만약에 초대장이 없으면 관중의 가방에서 티켓금액만큼 현금을 차감하고 티켓 오피스에 그 금액을 추가한다.
// 그런다음 관중의 가방에 금액을 넣어준다.

