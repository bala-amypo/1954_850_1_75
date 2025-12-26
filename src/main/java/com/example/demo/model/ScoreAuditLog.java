@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoreAuditLog {

    @Id
    @GeneratedValue
    private Long id;

    private Integer scoreChange;
    private String reason;
}
